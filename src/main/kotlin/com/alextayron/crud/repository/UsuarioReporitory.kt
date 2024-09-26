package com.alextayron.crud.repository

import com.alextayron.crud.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioReporitory : JpaRepository<Usuario, Long> {
}