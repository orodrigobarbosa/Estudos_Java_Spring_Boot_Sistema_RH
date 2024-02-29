package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.models.Candidato;
import com.AppRH.AppRH.models.Vaga;
import com.AppRH.AppRH.repository.CandidatoRepository;
import com.AppRH.AppRH.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class VagaController {

    private VagaRepository vr;
    private CandidatoRepository cr;


    //cadastro de vagas
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    //mapeia a rota e define o endereço da url durante uma requisição
    public String form() {
        return "vaga/formVaga";
    }


    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos.");
            return "redirect:/cadastrarVaga";

        }
        vr.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
        return "redurect:/cadastrarVaga";

    }
}
