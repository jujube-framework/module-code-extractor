# module-code-extractor
模块代码提取器。公司内部一些好的模块想要开源给社区，但内部代码使用Maven组合来组织的。如果只开源B模块的话，B会引用A，而A中有些代码是不需要开源的。这里做一个工具，把B中引用A的代码给单独提取出来！