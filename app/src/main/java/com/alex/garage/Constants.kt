package com.alex.garage

const val MQTT_SERVER_URI       = "tcp://192.168.0.54:1883"
const val MQTT_CLIENT_ID        = "Android"
const val MQTT_USERNAME         = ""
const val MQTT_PWD              = ""

const val MQTT_TEST_TOPIC       = "test/topic"
const val MQTT_TEST_MSG         = "Hello!"

const val MQTT_GARAGE_TOPIC       = "homeassistant/sensor/84f3eb25ed17/do"
const val MQTT_GARAGE_MSG         = "BUTTONGarage"

const val MQTT_LIGHT_TOPIC       = "homeassistant/sensor/483fda75b4b7/do"
const val MQTT_LIGHTON_MSG         = "SWITCHOn"
const val MQTT_LIGHTOFF_MSG         = "SWITCHOff"

const val MQTT_STATE_TOPIC_LIGHT       =  "homeassistant/sensor/483fda75b4b7/state"
const val MQTT_STATE_TOPIC_GARAGE       =  "homeassistant/sensor/84f3eb25ed17/state"
