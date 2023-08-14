package com.example.manytomany;

import com.example.manytomany.entity.Posts;
import com.example.manytomany.entity.Tags;
import com.example.manytomany.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public void run(String... args) throws Exception {
        Posts post = new Posts(
                "helloworld","helloworld","helloworld"
        );

        Tags hello = new Tags("Hello tag ");
        Tags world = new Tags("world tag");

        post.getTagsSet().add(hello);
        post.getTagsSet().add(world);

        world.getPostsSet().add(post);
        this.postsRepository.save(post);
    }
}
