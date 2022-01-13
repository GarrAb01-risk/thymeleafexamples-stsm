/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package thymeleafexamples.stsm.business.services;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import thymeleafexamples.stsm.business.entities.Feature;
import thymeleafexamples.stsm.business.entities.Row;
import thymeleafexamples.stsm.business.entities.SeedStarter;
import thymeleafexamples.stsm.business.entities.Type;
import thymeleafexamples.stsm.business.entities.repositories.SeedStarterRepository;
import thymeleafexamples.stsm.business.entities.repositories.VarietyRepository;

@Service
public class SeedStarterService {

    @Autowired
    private SeedStarterRepository seedstarterRepository; 

    @Autowired
    private VarietyRepository varieties;


    public SeedStarterService() {
        super();
    }
    

    @PostConstruct
    private void init() {
        int i = 1;
        var ss1 = new SeedStarter();
        ss1.setId(i);
        ss1.setCovered(true);
        ss1.setDatePlanted(new Date());
        ss1.setFeatures(new Feature[] { Feature.FERTILIZER, Feature.PH_CORRECTOR });
        ss1.setType(Type.WOOD);
        ss1.getRows().add(new Row(varieties.findById(i), i));
        this.add(ss1);
        i++;

        var ss2 = new SeedStarter();
        ss2.setId(i);
        ss2.setCovered(true);
        ss2.setDatePlanted(new Date());
        ss2.setFeatures(new Feature[] { Feature.SEEDSTARTER_SPECIFIC_SUBSTRATE, Feature.PH_CORRECTOR });
        ss2.setType(Type.PLASTIC);
        ss2.getRows().add(new Row(varieties.findById(i), i));
        this.add(ss2);
    }

    public List<SeedStarter> findAll() {
        return this.seedstarterRepository.findAll();
    }

    public void add(final SeedStarter seedStarter) {
        this.seedstarterRepository.add(seedStarter);
    }
    
}
