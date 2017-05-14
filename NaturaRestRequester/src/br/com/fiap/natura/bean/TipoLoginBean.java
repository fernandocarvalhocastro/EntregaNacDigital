package br.com.fiap.natura.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.fiap.natura.entity.TipoLogin;

@ManagedBean
public class TipoLoginBean {
	public SelectItem[] getTipoLoginValues() {
		SelectItem[] items = new SelectItem[TipoLogin.values().length];
		int i = 0;
		for (TipoLogin t : TipoLogin.values()) {
			items[i++] = new SelectItem(t, t.getLabel());
		}
		return items;
	}
}
