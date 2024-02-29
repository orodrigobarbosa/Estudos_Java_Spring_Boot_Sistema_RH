package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.models.Candidato;
import com.AppRH.AppRH.models.Vaga;
import com.AppRH.AppRH.repository.CandidatoRepository;
import com.AppRH.AppRH.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
        return "redirect:/cadastrarVaga";
    }

    //Lista vagas
    @RequestMapping("/vagas")
    public ModelAndView listaVagas(){
        ModelAndView mv = new ModelAndView("vaga/listaVaga");
        Iterable<Vaga> vagas = vr.findAll();
        mv.addObject("vagas", vagas);
        return mv;

    }

    //
 @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView  detalhesVaga(@PathVariable("codigo") long codigo){
        Vaga vaga = vr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("vaga/detalhesVaga");

        mv.addObject("vaga", vaga);

        Iterable<Candidato>candidatos = cr.findByVaga(vaga);
        mv.addObject("candidatos", candidatos);
        return mv;
    }


}
