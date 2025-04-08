
package com.matheus.restaurante.controller;

import com.matheus.restaurante.model.*;
import com.matheus.restaurante.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comandas")
public class ComandaController {

    @Autowired private ComandaRepository comandaRepo;
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private PratoRepository pratoRepo;
    @Autowired private ComandaItemRepository itemRepo;

    @PostMapping("/nova")
    public ResponseEntity<?> novaComanda(@RequestParam Long idCliente) {
        Usuario cliente = usuarioRepo.findById(idCliente).orElse(null);
        if (cliente == null) return ResponseEntity.badRequest().body("Cliente não encontrado");

        Comanda comanda = new Comanda();
        comanda.setCliente(cliente);
        return ResponseEntity.ok(comandaRepo.save(comanda));
    }

    @PostMapping("/{id}/adicionar")
    public ResponseEntity<?> adicionarItem(@PathVariable Long id, @RequestParam Long idPrato, @RequestParam int qtd) {
        Comanda comanda = comandaRepo.findById(id).orElse(null);
        Prato prato = pratoRepo.findById(idPrato).orElse(null);
        if (comanda == null || prato == null) return ResponseEntity.badRequest().body("Comanda ou prato não encontrado");

        ComandaItem item = new ComandaItem();
        item.setComanda(comanda);
        item.setPrato(prato);
        item.setQuantidade(qtd);
        itemRepo.save(item);
        return ResponseEntity.ok("Item adicionado");
    }

    @GetMapping
    public List<Comanda> listar() {
        return comandaRepo.findAll();
    }

    @GetMapping("/{id}/itens")
    public List<ComandaItem> listarItens(@PathVariable Long id) {
        return itemRepo.findByComandaId(id);
    }
}
