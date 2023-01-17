package com.hansey.facebookclone.service;

import com.hansey.facebookclone.model.Post;
import com.hansey.facebookclone.repository.PostEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    public PostServiceImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    private PostEntityRepository postEntityRepository;

    @Override
    public Post addPost(Post post) {
        try
        return null;
    }
}
