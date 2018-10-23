### Protocol Buffer

1.Protocol Buffer 是 Google出品的一种轻量 & 高效的**结构化** **数据存储**格式

>类比于 XML JSON
>
>Protocol Buffer序列化数据成二进制 - 体积更小 过程更快 传输更快 且通信过程更安全(因其传输的是二进制数据)
>
>同样支持多平台
>
>核心是利用.proto文件 定义数据结构 然后用protoc compile工具将其翻译成不同平台可以识别的代码文件并内置了一系列的操作

2.环境配置

>1.需要proto编译器 [Protocol Buffer](https://github.com/protocolbuffers/protobuf)
>
>2.使用的时候需要引入对应的依赖<其中包含一些接口 方法 数据类型的定义>

