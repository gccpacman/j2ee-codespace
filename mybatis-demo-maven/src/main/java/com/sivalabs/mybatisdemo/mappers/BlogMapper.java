package com.sivalabs.mybatisdemo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sivalabs.mybatisdemo.domain.Blog;

public interface BlogMapper {
	
	@Insert("INSERT INTO blog(BLOG_NAME, CREATED_ON) VALUES(#{blogName}, #{createdOn})")
	@Options(useGeneratedKeys = true, keyProperty = "blogId")
	public void insertBlog(Blog blog);

	@Select("SELECT BLOG_ID AS blogId, BLOG_NAME as blogName, CREATED_ON as createdOn FROM blog WHERE BLOG_ID=#{blogId}")
	public Blog getBlogById(Integer blogId);

	@Select("SELECT * FROM blog ")
	@Results({ @Result(id = true, property = "blogId", column = "blog_id"),
			@Result(property = "blogName", column = "blog_name"),
			@Result(property = "createdOn", column = "created_on") })
	public List<Blog> getAllBlogs();

	@Update("UPDATE blog SET BLOG_NAME=#{blogName}, CREATED_ON=#{createdOn} WHERE BLOG_ID=#{blogId}")
	public void updateBlog(Blog blog);

	
	@Delete("DELETE FROM blog WHERE BLOG_ID=#{blogId}")
	public void deleteBlog(Integer blogId);

}