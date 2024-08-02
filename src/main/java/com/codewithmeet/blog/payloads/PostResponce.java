package com.codewithmeet.blog.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponce {
	
	private List<PostDto> content;
	private int pagesize;
	private int pagenumber;
	private long totalElement;
	private int totalpage;
	private boolean lastpage;
}
