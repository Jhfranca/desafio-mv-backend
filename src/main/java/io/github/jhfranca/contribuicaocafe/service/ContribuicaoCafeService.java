package io.github.jhfranca.contribuicaocafe.service;

import io.github.jhfranca.contribuicaocafe.dto.SalvarContribuicaoResponse;
import io.github.jhfranca.contribuicaocafe.entity.ContribuicaoCafe;
import io.github.jhfranca.contribuicaocafe.repository.ContribuicaoCafeRepository;
import io.github.jhfranca.contribuicaocafe.repository.ItemCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ContribuicaoCafeService {

    @Autowired
    private ContribuicaoCafeRepository repository;

    @Autowired
    private ItemCafeRepository itemCafeRepository;

    public SalvarContribuicaoResponse save(ContribuicaoCafe contribuicaoCafe){
        var itensJaExitentes = contribuicaoCafe.getItens()
                .stream()
                .filter(itemCafe -> itemCafeRepository.existsItemCafeByItemEquals(itemCafe.getItem()))
                .collect(Collectors.toList());

        if(!itensJaExitentes.isEmpty()) {
            contribuicaoCafe.getItens().removeIf(itensJaExitentes::contains);
        }

        this.repository.save(contribuicaoCafe);

        return new SalvarContribuicaoResponse(contribuicaoCafe.getItens(), itensJaExitentes);
    }

    public SalvarContribuicaoResponse update(ContribuicaoCafe contribuicaoCafe) throws NotFoundException {
        if(Objects.nonNull(contribuicaoCafe.getId()) && repository.existsById(contribuicaoCafe.getId())){
            return save(contribuicaoCafe);
        } else {
            throw new NotFoundException();
        }
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<ContribuicaoCafe> findAll(){
        return repository.findAll();
    }

    public ContribuicaoCafe findById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
