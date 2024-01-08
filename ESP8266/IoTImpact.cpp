#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <Wire.h>
#include <RtcDS3231.h>
#include <ArduinoJson.h>

WiFiClient client;
HTTPClient httpClient;
RtcDS3231<TwoWire> Rtc(Wire);

const char *WIFI_SSID = "WIFI";
const char *WIFI_PASSWORD = "SENHA";
const char *URL = "URL";
const int impactSensorPin = D0;
unsigned long tempoUltimaDetecao = 0;

void setup() {
  Serial.begin(115200);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Rtc.Begin();

  RtcDateTime tempoatual = RtcDateTime(__DATE__, __TIME__);
  Rtc.SetDateTime(tempoatual);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("Connected");
  delay(2000);
}

void loop() {
  int impactValue = analogRead(impactSensorPin);

  RtcDateTime instante = Rtc.GetDateTime();
  char valores[20];
  char valores2[20];

  sprintf(valores, "%d:%d",
          instante.Hour(),
          instante.Minute());

  sprintf(valores2, "%d-%d-%d",
          instante.Year(),
          instante.Month(),
          instante.Day());

  if (digitalRead(impactSensorPin) == LOW && millis() - tempoUltimaDetecao >= 100) {

    DynamicJsonDocument jsonDocument(200);
    jsonDocument["impactValue"] = impactValue;
    jsonDocument["hora_impacto"] = valores;
    jsonDocument["data_impacto"] = valores2;

    String jsonData;
    serializeJson(jsonDocument, jsonData);

    httpClient.begin(client, URL);
    httpClient.addHeader("Content-Type", "application/json");
    httpClient.POST(jsonData);
    String content = httpClient.getString();
    httpClient.end();

    Serial.println(impactValue);
    Serial.println(valores);
    tempoUltimaDetecao = millis();
  }
}