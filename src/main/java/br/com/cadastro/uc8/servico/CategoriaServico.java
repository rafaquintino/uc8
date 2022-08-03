package br.com.cadastro.uc8.servico;

import java.util.List;

import br.com.cadastro.uc8.orm.Categoria;

public interface CategoriaServico {
	public List<Categoria> listarCategorias();
	
	public void apagarCategorias(Integer id);
	
	public Categoria consultarCategoriasId(Integer id);
	
	public Categoria apagarCategoria(Categoria categoria);
	
	public Categoria salvarCategoria(Categoria categoria);

	public Categoria atualizarCategorias(Categoria cat);

}
