package com.example.demo.common.exception

class InvalidInputException(
    val filedName: String = "",
    message: String = "Invalid Input"
) : RuntimeException(message)