package com.alex.garage

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.eclipse.paho.client.mqttv3.*


class MainActivity : AppCompatActivity() {

    private val permissions = arrayOf<String>(
        Manifest.permission.INTERNET,
        Manifest.permission.WAKE_LOCK,
        Manifest.permission.ACCESS_NETWORK_STATE
    )
    private val requestnumber = 1337

    private lateinit var mqttClient : MQTTClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!canAccessINTERNET() || !canAccessWAKELOCK() || !canAccessACCESSNETWORKSTATE()) {
            requestPermissions(permissions, requestnumber)
        } else {
            Log.d(this.javaClass.name, "All OK")
        }

        val clickme = findViewById<Button>(R.id.button)
        val clickmeLightOn = findViewById<Button>(R.id.buttonLightOn)
        val clickmeLightOff = findViewById<Button>(R.id.buttonLightOff)

        clickme.setOnClickListener {

         //   Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

            mqttClient = MQTTClient(this, MQTT_SERVER_URI, MQTT_CLIENT_ID)
            // Connect and login to MQTT Broker
            mqttClient.connect(MQTT_USERNAME,
                MQTT_PWD,
                object : IMqttActionListener {
                    override fun onSuccess(asyncActionToken: IMqttToken?) {
                        Log.d(this.javaClass.name, "Connection success")


                        mqttClient.publish(MQTT_GARAGE_TOPIC,
                            MQTT_GARAGE_MSG,
                            1,
                            false,
                            object : IMqttActionListener {
                                override fun onSuccess(asyncActionToken: IMqttToken?) {
                                    val msg =
                                        "Publish message: " + MQTT_GARAGE_MSG + " to topic: " + MQTT_GARAGE_TOPIC
                                    Log.d(this.javaClass.name, msg)
                                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                                }

                                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                    Log.d(this.javaClass.name, "Failed to publish message to topic")
                                }
                            })

                        mqttClient.disconnect()


                    }

                    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                        Log.d(this.javaClass.name, "Connection failure: ${exception.toString()}")
                    }
                },
                object : MqttCallback {
                    override fun messageArrived(topic: String?, message: MqttMessage?) {
                        val msg = "Receive message: ${message.toString()} from topic: $topic"
                        Log.d(this.javaClass.name, msg)
                    }

                    override fun connectionLost(cause: Throwable?) {
                        Log.d(this.javaClass.name, "Connection lost ${cause.toString()}")
                    }

                    override fun deliveryComplete(token: IMqttDeliveryToken?) {
                        Log.d(this.javaClass.name, "Delivery complete")
                    }
                })
        }
        clickmeLightOn.setOnClickListener {

            //   Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

            mqttClient = MQTTClient(this, MQTT_SERVER_URI, MQTT_CLIENT_ID)
            // Connect and login to MQTT Broker
            mqttClient.connect(MQTT_USERNAME,
                MQTT_PWD,
                object : IMqttActionListener {
                    override fun onSuccess(asyncActionToken: IMqttToken?) {
                        Log.d(this.javaClass.name, "Connection success")


                        mqttClient.publish(MQTT_LIGHT_TOPIC,
                            MQTT_LIGHTON_MSG,
                            1,
                            false,
                            object : IMqttActionListener {
                                override fun onSuccess(asyncActionToken: IMqttToken?) {
                                    val msg =
                                        "Publish message: " + MQTT_LIGHTON_MSG + " to topic: " + MQTT_LIGHT_TOPIC
                                    Log.d(this.javaClass.name, msg)
                                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                                }

                                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                    Log.d(this.javaClass.name, "Failed to publish message to topic")
                                }
                            })

                        mqttClient.disconnect()


                    }

                    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                        Log.d(this.javaClass.name, "Connection failure: ${exception.toString()}")
                    }
                },
                object : MqttCallback {
                    override fun messageArrived(topic: String?, message: MqttMessage?) {
                        val msg = "Receive message: ${message.toString()} from topic: $topic"
                        Log.d(this.javaClass.name, msg)
                    }

                    override fun connectionLost(cause: Throwable?) {
                        Log.d(this.javaClass.name, "Connection lost ${cause.toString()}")
                    }

                    override fun deliveryComplete(token: IMqttDeliveryToken?) {
                        Log.d(this.javaClass.name, "Delivery complete")
                    }
                })
        }
        clickmeLightOff.setOnClickListener {

            //   Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

            mqttClient = MQTTClient(this, MQTT_SERVER_URI, MQTT_CLIENT_ID)
            // Connect and login to MQTT Broker
            mqttClient.connect(MQTT_USERNAME,
                MQTT_PWD,
                object : IMqttActionListener {
                    override fun onSuccess(asyncActionToken: IMqttToken?) {
                        Log.d(this.javaClass.name, "Connection success")


                        mqttClient.publish(MQTT_LIGHT_TOPIC,
                            MQTT_LIGHTOFF_MSG,
                            1,
                            false,
                            object : IMqttActionListener {
                                override fun onSuccess(asyncActionToken: IMqttToken?) {
                                    val msg =
                                        "Publish message: " + MQTT_LIGHTOFF_MSG + " to topic: " + MQTT_LIGHT_TOPIC
                                    Log.d(this.javaClass.name, msg)
                                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                                }

                                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                    Log.d(this.javaClass.name, "Failed to publish message to topic")
                                }
                            })

                        mqttClient.disconnect()


                    }

                    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                        Log.d(this.javaClass.name, "Connection failure: ${exception.toString()}")
                    }
                },
                object : MqttCallback {
                    override fun messageArrived(topic: String?, message: MqttMessage?) {
                        val msg = "Receive message: ${message.toString()} from topic: $topic"
                        Log.d(this.javaClass.name, msg)
                    }

                    override fun connectionLost(cause: Throwable?) {
                        Log.d(this.javaClass.name, "Connection lost ${cause.toString()}")
                    }

                    override fun deliveryComplete(token: IMqttDeliveryToken?) {
                        Log.d(this.javaClass.name, "Delivery complete")
                    }
                })
        }

    }


    private fun canAccessINTERNET(): Boolean {
        Log.d(this.javaClass.name, "1")
        return hasPermission(Manifest.permission.INTERNET)
    }
    private fun canAccessWAKELOCK(): Boolean {
        Log.d(this.javaClass.name, "2")
        return hasPermission(Manifest.permission.WAKE_LOCK)
    }
    private fun canAccessACCESSNETWORKSTATE(): Boolean {
        Log.d(this.javaClass.name, "3")
        return hasPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    }


    private fun hasPermission(perm: String): Boolean {
        return PackageManager.PERMISSION_GRANTED == checkSelfPermission(perm)
    }

}