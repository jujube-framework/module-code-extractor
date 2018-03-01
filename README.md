# module-code-extractor
模块代码提取器。    
公司内部一些好的模块想要开源给社区，但内部代码使用Maven组合来组织的。如果只开源B模块的话，B会引用A，而A中有些代码是不需要开源的。这里做一个工具，把B中引用A的代码给单独提取出来！    

# usage
查看CodeExtractorTest类。    
效果为：persistence-base中引用到的core类会被复制到Easy-Jdbc项目下。最后把persistence-base中的代码也复制到Easy-Jdbc下就完成了persistence的开源提取！
