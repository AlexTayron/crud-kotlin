package com.alextayron.crud.controller

import com.alextayron.crud.model.Usuario
import com.alextayron.crud.repository.UsuarioReporitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UsuarioController {

    @Autowired
    lateinit var repository: UsuarioReporitory

    @GetMapping("/formulario/cadastro")
    fun abrirFormularioCadastro(model: Model) : String {
        val usuario = Usuario()
        model.addAttribute("usuario", usuario)
        return "formulario-cadastro"
    }

    @PostMapping("/cadastrar")
    fun cadastrarUsuario(@Validated usuario: Usuario, result: BindingResult):String{
        if(result.hasErrors()){
            return "formulario-cadastro"
        }
        println(usuario)
        repository.save(usuario)
        return "redirect:/home"
    }

    @GetMapping("/home")
    fun abrirHome(model: Model): String {

        val usuarios = repository.findAll()

        model.addAttribute("usuarios", usuarios)

        return "home"
    }

    @GetMapping("/formulario/edicao/{id}")
    fun abrirFormularioEdicao(@PathVariable("id") id: Long, model: Model): String {

        val usuario = repository.findById(id).orElse(null)
        model.addAttribute("usuario", usuario)
        return  "formulario-edicao"
    }

    @PostMapping("/editar/{id}")
    fun editarUsuario(usuario: Usuario, @PathVariable("id") id: Long) : String {

        usuario.id = id

        repository.save(usuario)

        return "redirect:/home"

    }

    @GetMapping("/excluir/{id}")
    fun excluirUsuario(@PathVariable("id") id: Long): String {

        repository.deleteById(id)

        return "redirect:/home"
    }
}