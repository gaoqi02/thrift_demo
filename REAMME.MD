##1.thrift简介
thrift是一个软件框架，用来进行可扩展且跨语言的服务的开发。它结合了功能强大的软件堆栈和代码生成引擎，以构建再C++，Java，Go，Python，PHP等编程语言间无缝结合的、高效的服务。</br>
mac配置thrift</br>
使用 Mac 的包管理器 Homebrew。如果没有安装，请执行：</br>
ruby -e "$(curl -fsSL https://raw.github.com/Homebrew/homebrew/go/install)"  </br>
然后执行 brew install thrift 进行安装。</br>
检验是否安装成功，执行thrift -version。输出</br>
Thrift version 0.10.0</br>
则成功</br>
thrift基本语法</br>
类型</br>
thrift类型系统包括预定义的基本类型，用户自定义的结构体，容器类型，异常和服务</br>
基本类型
</br>
bool:布尔类型，对应java的boolean</br>
byte:8位带符号整数，对应java的byte</br>
i16:16位带符号整数，对应java的short</br>
i32:32位带符号整数，对应java的int</br>
i64:64位带符号整数，对应java的long</br>
double:64位浮点数，对应java的double</br>
string：采用utf-8编码的字符串，对应java的String</br>
特殊类型

binary:未经编码的字节流，对应java的ByteBuffer</br>
Structs结构，对应java的普通类。</br>
容器</br>

list，对应java中的java.util.ArrayList</br>
set，对应java中的java.util.HashSet</br>
map，对应java中的java.util.HashMap</br>

Services服务</br>

enum枚举类型</br>
exception异常类型，对应java的Exception</br>
变量声明</br>
typedef bool isBool</br>
typedef byte isByte</br>
常量</br>
const i32 INT_CONST = 1234;</br>
命名空间</br>
namespace java com.example.project </br>
文件引用</br>
include "Calculator.thrift"</br>