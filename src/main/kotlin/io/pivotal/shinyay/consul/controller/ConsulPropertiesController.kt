package io.pivotal.shinyay.consul.controller

import io.pivotal.shinyay.consul.property.PropsFromConsul
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ConsulPropertiesController(val propsFromConsul: PropsFromConsul) {

    @Value("\${my.prop}")
    lateinit var value: String

    @GetMapping("/value")
    fun getFromValue() = value

    @GetMapping("/prop")
    fun getFromProps() = propsFromConsul.prop
}