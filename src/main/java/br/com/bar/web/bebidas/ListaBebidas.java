package br.com.bar.web.bebidas;


import java.util.List;

import br.com.bar.dao.BebidaDAO;
import br.com.bar.service.BebidaService;

public class ListaBebidas {
	private BebidaService service = new BebidaService();
	
    public ListaBebidas() {
    	
    }

    public List<BebidaDAO> findAll(){
    	return service.findAll();
    }
    
    

}
