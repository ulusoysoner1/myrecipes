package com.eteration.myrecipes.Controller;

import com.eteration.myrecipes.Dto.CommentDto;
import com.eteration.myrecipes.Entity.Comment;
import com.eteration.myrecipes.Service.Abstract.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
public class CommentController {


    private final ModelMapper modelMapper;

    private final CommentService commentService;

    public CommentController(ModelMapper modelMapper, CommentService commentService) {
        this.modelMapper = modelMapper;
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDto> getAllUsers() {
        return commentService.getAllComments().stream().map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{commentId")
    public ResponseEntity<CommentDto> getUserById(Integer commentId) {
        Comment comment = commentService.getCommentById(commentId);
        CommentDto commentResponse = modelMapper.map(comment, CommentDto.class);

        return ResponseEntity.ok().body(commentResponse);
    }

    @PostMapping
    public ResponseEntity<CommentDto> createUser(@RequestBody CommentDto commentDto) {

        Comment commentRequest = modelMapper.map(commentDto, Comment.class);
        Comment comment = commentService.createComment(commentRequest);

        CommentDto commentResponse = modelMapper.map(comment, CommentDto.class);

        return new ResponseEntity<CommentDto>(commentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateUser(@PathVariable Integer commentId, @RequestBody CommentDto commentDto) {

        Comment commentRequest = modelMapper.map(commentDto, Comment.class);

        Comment comment = commentService.updateComment(commentId, commentRequest);


        CommentDto commentResponse = modelMapper.map(comment, CommentDto.class);

        return ResponseEntity.ok().body(commentResponse);
    }
}

