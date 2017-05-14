package br.com.fiap.natura.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.fiap.natura.entity.TipoUsuario;

@ManagedBean
public class TipoUsuarioBean {
	public SelectItem[] getTipoUsuarioValues() {
		SelectItem[] items = new SelectItem[TipoUsuario.values().length];
		int i = 0;
		for (TipoUsuario t : TipoUsuario.values()) {
			items[i++] = new SelectItem(t, t.getLabel());
		}
		return items;
	}
}
