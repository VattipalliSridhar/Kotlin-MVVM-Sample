package com.apps.kotlinmvvm.view.baseclass

import java.io.IOException

class ApiException(message: String) : IOException(message)
class NoInternetException(message: String) : IOException(message)