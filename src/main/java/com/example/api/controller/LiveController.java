package com.example.api.controller;

import com.example.api.model.Live;
import com.example.api.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("live")
public class LiveController {
    @Autowired
    LiveService liveService;

    @RequestMapping(method = RequestMethod.POST)
    Live postLive(@RequestBody Live live) {
        return liveService.postLive(live);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Live> getLive() {
        return liveService.getLive();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Live putLive(@PathVariable("id") Integer id, @RequestBody Live live) {
        live.setId(id);
        return liveService.updateLive(live);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteLive() {
        liveService.getLive().forEach(live -> {
            liveService.deleteLive(live.getId());
        });
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void deleteLive(@PathVariable("id") Integer id) {
        liveService.deleteLive(id);
    }
}