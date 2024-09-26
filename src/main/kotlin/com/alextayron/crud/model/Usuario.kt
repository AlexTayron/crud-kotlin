package com.alextayron.crud.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF
import kotlin.math.min

@Entity
data class Usuario (

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @field:NotBlank(message = "O Nome é obrigatório")
    val nome: String = "",

    @field:NotBlank(message = "O Email é obrigatório")
    @field:Email(message = "Email inválido")
    val email: String = "",

    val telefone: String = "",

    @field:NotBlank(message = "O CPF é obrigatório")
    @field:CPF(message = "CPF Inválido")
    val cpf : String = "",

    @field:NotBlank(message = "A Senha é obrigatória")
    @field:Size(min = 6, max = 16, message = "A Senha deve ter entre 6 e 16 caracteres")
    val senha: String = "",

    val setor: String = ""
) {


}