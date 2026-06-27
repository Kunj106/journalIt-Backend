package com.kunj.Journalt.cache;

import com.kunj.Journalt.entity.ConfigJournalAppEntry;
import com.kunj.Journalt.repository.ConfigJournalRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache
{
    // Load entire mongodb collection in this class
    // Loads only once which reduces latency and is stored as cache in memory

    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private ConfigJournalRepository configJournalRepository;

    public Map<String,String> APP_CACHE = new HashMap<>();

    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntry> all = configJournalRepository.findAll();
        for(ConfigJournalAppEntry configJournalAppEntry : all){
            APP_CACHE.put(configJournalAppEntry.getKey(),configJournalAppEntry.getValue());
        }
    }
}
