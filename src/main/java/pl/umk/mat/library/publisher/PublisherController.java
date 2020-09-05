package pl.umk.mat.library.publisher;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/all")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }


    @GetMapping()
    public List<Publisher> getPublishersByName(String name) {
        return publisherRepository.getPublishersByNameLike("%" + name + "%");
    }

    @GetMapping("/id")
    public Publisher getPublishersById(Long id) {
        return publisherRepository.getPublishersById(id);
    }

    @PostMapping
    public Publisher addPublisher(@RequestBody PublisherAddRequest publisherAddRequest) {
        System.out.println(publisherAddRequest);
        Publisher publisher = new Publisher(
                publisherAddRequest.getName(),
                publisherAddRequest.getPhoneNumber(),
                publisherAddRequest.getCountry()
        );
        publisherRepository.save(publisher);
        return publisher;
    }

}
