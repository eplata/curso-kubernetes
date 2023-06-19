package com.udemy.eplata.springcloud.msvc.cursos.clients;
import com.udemy.eplata.springcloud.msvc.cursos.models.Usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//name es el nombre del microservicio que se va a consumir
//url host donde esta el micro
@FeignClient(name = "msvc-usuarios", url="localhost:8001") 
public interface UsuarioClientRest {


	
	@GetMapping("/{id}")
	public Usuario detalle (@PathVariable Long id);
	
	@PostMapping("/")
	public Usuario crear(@RequestBody Usuario usuario);	
}
