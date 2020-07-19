package com.heads.thinking.funnytests.exception

import java.lang.Exception

class TestException(val detailedMessage: String): Exception("Test is incorrect") {
}