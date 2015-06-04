package com.sivalabs.mybatisdemo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sivalabs.mybatisdemo.domain.Blog;
import com.sivalabs.mybatisdemo.mappers.BlogMapper;

public class BlogService {

	public void insertBlog(Blog blog) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.insertBlog(blog);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Blog getBlogById(Integer blogId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			return blogMapper.getBlogById(blogId);
		} finally {
			sqlSession.close();
		}
	}

	public List<Blog> getAllBlogs() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			return blogMapper.getAllBlogs();
		} finally {
			sqlSession.close();
		}
	}

	public void updateBlog(Blog blog) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.updateBlog(blog);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteBlog(Integer blogId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.deleteBlog(blogId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

}