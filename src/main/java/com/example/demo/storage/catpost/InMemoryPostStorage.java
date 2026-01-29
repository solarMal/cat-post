package com.example.demo.storage.catpost;

import com.example.demo.exception.PostNotFoundException;
import com.example.demo.exception.ValidateException;
import com.example.demo.model.CatPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class InMemoryPostStorage implements CatPostStorage {
    Map<Long, CatPost> postMap = new HashMap<>();
    private long dynamicId = 1;

    @Override
    public CatPost createPost(CatPost catPost) {
        catPost.setId(dynamicId++);
        postMap.put(catPost.getId(), catPost);
        log.info("пост {} успешно добавлен", catPost);
        return catPost;
    }

    @Override
    public CatPost updatePost(CatPost catPost) {
        if (!postMap.containsKey(catPost.getId())) {
            throw new PostNotFoundException("post with id " + catPost.getId() + " not found");
        }

        postMap.put(catPost.getId(), catPost);
        log.info("post {} update", catPost);
        return catPost;
    }

    @Override
    public CatPost getPostById(long id) {
        return Optional.ofNullable(postMap.get(id))
                .orElseThrow(() -> new PostNotFoundException("post with id " + id + " not found"));
    }

    @Override
    public List<CatPost> getAllPosts() {
        if (postMap.isEmpty()) {
              log.debug("postMap is empty");
        }
        return new ArrayList<>(postMap.values());
    }

    @Override
    public void deletePostById(long id) {
        if (id < 0) {
            throw new ValidateException("id must be positive");
        }
        CatPost catPost = postMap.remove(id);

        if (catPost == null) {
            throw new PostNotFoundException("post not found");
        }
        log.info("post with id {} removed", id);
    }


}
