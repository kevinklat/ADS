package br.com.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.vo.CombustivelVo;

@Named("CombustivelMB")
@SessionScoped
public class CombustivelMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private CombustivelVo combustivel = new CombustivelVo();
	private List<CombustivelVo> listaCombustivel = new ArrayList<CombustivelVo>();
	
	public CombustivelMB() {
		super();
	}

	public CombustivelVo getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(CombustivelVo combustivel) {
		this.combustivel = combustivel;
	}
	
	public List<CombustivelVo> getListarCombustiveis() {
		return listaCombustivel;
	}

	public void setListarCombustiveis(List<CombustivelVo> listaCombustivel) {
		this.listaCombustivel = listaCombustivel;
	}
	
	
	public String efetuarCadastro() {
		combustivel.setCodigo(listaCombustivel.size()+1);
		listaCombustivel.add(combustivel);
		
		combustivel = new CombustivelVo();
		return "questão-u2-t1";
	}
	
	public String excluirCombustivel(int codigo) {
		for(int i = listaCombustivel.size()-1;i >= 0; i--) {
			if (listaCombustivel.get(i).getCodigo() == codigo) {
				listaCombustivel.remove(i);
			}
		}
		return "questão-u2-t1";
	}
	

}
