package com.platzi.platzimarket.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMPRAS_PRODUCTOS")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK idCompraProducto;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name ="id_compra", updatable = false, insertable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name ="id_producto", updatable = false, insertable = false)
    private Producto producto;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ComprasProductoPK getIdCompraProducto() {
        return idCompraProducto;
    }

    public void setIdCompraProducto(ComprasProductoPK idCompraProducto) {
        this.idCompraProducto = idCompraProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
