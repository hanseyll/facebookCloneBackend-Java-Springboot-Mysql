package com.hansey.facebookclone.service;

import com.hansey.facebookclone.entity.PostEntity;
import com.hansey.facebookclone.model.Post;
import com.hansey.facebookclone.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    public PostServiceImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    private PostEntityRepository postEntityRepository;

    @Override
    public Post addPost(Post post) throws Exception {
        try{
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post,postEntity);

            if(post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
                postEntity.setImage(post.getFile());
            else
                postEntity.setImage(null);
            postEntity = postEntityRepository.save(postEntity);

            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());
        }catch(Exception e){
            throw new Exception("Could not save Post: " + e);

        }
        return post;
    }
}
