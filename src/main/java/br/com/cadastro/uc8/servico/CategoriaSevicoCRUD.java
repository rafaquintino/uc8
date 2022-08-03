package br.com.cadastro.uc8.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.uc8.orm.Categoria;
import br.com.cadastro.uc8.repository.CategoriaRepository;

@Service
public class CategoriaSevicoCRUD implements CategoriaServico{
	
	@Autowired
	private CategoriaRepository repositorio;
	
	public List<Categoria> listarCategorias(){
		return (List<Categoria>) repositorio.findAll();
	}

	public void apagarCategorias(Integer id) {	
		repositorio.deleteById(id);
		
	}

	public Categoria consultarCategoriaId(Integer id) {
		return repositorio.findById(id).get();
		
	}
	public Categoria atualizarCategorias(Categoria categoria) {
		return repositorio.save(categoria);
	}

	public Categoria salvarCategorias(Categoria categoria){
		return repositorio.save(categoria);
		
	}

	public void apagarCategorias() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria consultarCategoriasId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria apagarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria salvarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
}

