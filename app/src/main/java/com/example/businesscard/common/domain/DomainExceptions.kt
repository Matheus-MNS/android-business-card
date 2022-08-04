package com.example.businesscard.common.domain

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

sealed class ParamException(message: String, title: String? = null) :
    DomainException(message, title)

class EmptyNameException: ParamException("Campo de preenchimento obrigatório: Nome")
class EmptyCompanyException: ParamException("Campo de preenchimento obrigatório: Empresa")
class EmptyPhoneException: ParamException("Campo de preenchimento obrigatório: Telefone")
class EmptyEmailException: ParamException("Campo de preenchimento obrigatório: Email")
