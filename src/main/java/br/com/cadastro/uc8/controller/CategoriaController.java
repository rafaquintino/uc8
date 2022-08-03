package br.com.cadastro.uc8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.cadastro.uc8.orm.Categoria;
import br.com.cadastro.uc8.servico.CategoriaServico;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping({"/categoria"})
	public String listarCategorias(Model modelo) {
		modelo.addAttribute("categoria", servico.listarCategorias());
		return "categoria";
	}
	@GetMapping({"/categoria/{id}"})
	public String apagarCategorias(@PathVariable Integer id) {
		servico.apagarCategorias(id);
		return "/redirect:/categoria";
	}

	@GetMapping({"/categoria/editar/{id}"})
	public String editarCategorias(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("categoria",servico.consultarCategoriasId(id));
		return "editarCategoria";
	}

	@PostMapping({"/categoria/{id}"})
	public String atualizarategoria(@PathVariable Integer id,@ModelAttribute("categoria") Categoria categoria, Model modelo) {
		Categoria cat = servico.consultarCategoriasId(id);
		cat.setId(id);
		cat.setValor(categoria.getValor());
		cat.setNome(categoria.getNome());
		servico.atualizarCategorias(cat);
		return "redirect:/categoria";
	}		
	@GetMapping("/categoria/adicionar")
	public String adicionarCategorias(Model modelo) {
		Categoria categoria = new Categoria();
		modelo.addAttribute("categoria", categoria);
		return "formCategoria";

	}
	@PostMapping("/categoria")
	public String salvarCategorias(@ModelAttribute("categoria") Categoria categoria) {
		servico.salvarCategoria(categoria);
		return "redirect:/categoria";
	}



}