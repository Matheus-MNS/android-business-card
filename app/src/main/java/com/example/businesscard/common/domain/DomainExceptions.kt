package com.example.businesscard.common.domain

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

sealed class ParamException(message: String, title: String? = null) :
    DomainException(message, title)

class EmptyNameException: ParamException("Obrigatorio preencher nome")
class EmptyCompanyException: ParamException("Obrigatorio preencher nome da empresa")
class EmptyPhoneException: ParamException("Obrigatorio preencher telefone")
class EmptyEmailException: ParamException("Obrigatorio preencher email")
