# Consul
封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。
什么是Consul

Consul是HashiCorp公司推出的开源软件，使用GO语言编写，提供了分布式系统的服务注册和发现、配置等功能，这些功能中的每一个都可以根据需要单独使用，也可以一起使用以构建全方位的服务网格。Consul不仅具有服务治理的功能，而且使用分布式一致协议RAFT算法实现，有多数据中心的高可用方案，并且很容易和Spring Cloud等微服务框架集成，使用起来非常的简单，具有简单、易用、可插排等特点。使用简而言之，Consul提供了一种完整的服务网格解决方案 。
Consul具有以下的特点和功能

    服务发现：Consul的客户端可以向Consul注册服务，例如api服务或者mysql服务，其他客户端可以使用Consul来发现服务的提供者。Consul支持使用DNS或HTTP来注册和发现服务。
    运行时健康检查：Consul客户端可以提供任意数量的运行状况检查机制，这些检查机制可以是给定服务（“是Web服务器返回200 OK”）或本地节点（“内存利用率低于90％”）相关联。这些信息可以用来监控群集的运行状况，服务发现组件可以使用这些监控信息来路由流量，可以使流量远离不健康的服务。
    KV存储：应用程序可以将Consul的键/值存储用于任何需求，包括动态配置，功能标记，协调，领导者选举等。它采用HTTP API使其易于使用。
    安全服务通信：Consul可以为服务生成和分发TLS证书，以建立相互的TLS连接。
    多数据中心：Consul支持多个数据中心。这意味着Consul的用户不必担心构建额外的抽象层以扩展到多个区域。

Consul原理

每个提供服务的节点都运行了Consul的代理，运行代理不需要服务发现和获取配置的KV键值对，代理只负责监控检查。代理节点可以和一个或者多个Consul server通讯。 Consul服务器是存储和复制数据的地方。服务器本身选出了领导者。虽然Consul可以在一台服务器上运行，但建议使用3到5，以避免导致数据丢失的故障情况。建议为每个数据中心使用一组Consul服务器。 如果你的组件需要发现服务，可以查询任何Consul Server或任何Consul客户端，Consul客户端会自动将查询转发给Consul Server。 需要发现其他服务或节点的基础架构组件可以查询任何Consul服务器或任何Consul代理。代理会自动将查询转发给服务器。每个数据中心都运行Consul服务器集群。发生跨数据中心服务发现或配置请求时，本地Consul服务器会将请求转发到远程数据中心并返回结果。

术语

    Agent agent是一直运行在Consul集群中每个成员上的守护进程。通过运行 consul agent 来启动。agent可以运行在client或者server模式。指定节点作为client或者server是非常简单的，除非有其他agent实例。所有的agent都能运行DNS或者HTTP接口，并负责运行时检查和保持服务同步。
    Client 一个Client是一个转发所有RPC到server的代理。这个client是相对无状态的。client唯一执行的后台活动是加入LAN gossip池。这有一个最低的资源开销并且仅消耗少量的网络带宽。
    Server 一个server是一个有一组扩展功能的代理，这些功能包括参与Raft选举，维护集群状态，响应RPC查询，与其他数据中心交互WAN gossip和转发查询给leader或者远程数据中心。
    DataCenter 虽然数据中心的定义是显而易见的，但是有一些细微的细节必须考虑。例如，在EC2中，多个可用区域被认为组成一个数据中心？我们定义数据中心为一个私有的，低延迟和高带宽的一个网络环境。这不包括访问公共网络，但是对于我们而言，同一个EC2中的多个可用区域可以被认为是一个数据中心的一部分。
    Consensus 在我们的文档中，我们使用Consensus来表明就leader选举和事务的顺序达成一致。由于这些事务都被应用到有限状态机上，Consensus暗示复制状态机的一致性。
    Gossip Consul建立在Serf的基础之上，它提供了一个用于多播目的的完整的gossip协议。Serf提供成员关系，故障检测和事件广播。更多的信息在gossip文档中描述。这足以知道gossip使用基于UDP的随机的点到点通信。
    LAN Gossip 它包含所有位于同一个局域网或者数据中心的所有节点。
    WAN Gossip 它只包含Server。这些server主要分布在不同的数据中心并且通常通过因特网或者广域网通信。
    RPC 远程过程调用。这是一个允许client请求server的请求/响应机制。


Consul VS Eureka

Eureka是一种服务发现工具。 该体系结构主要是客户端/服务器，每个数据中心有一组Eureka服务器，通常每个可用区域一个。 通常，Eureka的客户使用嵌入式SDK来注册和发现服务。 对于非本地集成的客户端，使用Ribbon等边车通过Eureka透明地发现服务。

Eureka使用尽力而为的复制提供弱一致的服务视图。 当客户端向服务器注册时，该服务器将尝试复制到其他服务器但不提供保证。 服务注册的生存时间很短（TTL），要求客户端对服务器进行心跳检测。 不健康的服务或节点将停止心跳，导致它们超时并从注册表中删除。 发现请求可以路由到任何服务，由于尽力复制，这些服务可以提供过时或丢失的数据。 这种简化的模型允许轻松的集群管理和高可扩展性。

Consul提供了一系列超级功能，包括更丰富的运行状况检查，键/值存储和多数据中心感知。 Consul需要每个数据中心中的一组服务器，以及每个客户端上的代理，类似于使用像Ribbon这样的边车。 Consul代理允许大多数应用程序不知道Consul，通过配置文件执行服务注册以及通过DNS或负载平衡器sidecars进行发现。

Consul提供强大的一致性保证，因为服务器使用Raft协议复制状态。 Consul支持丰富的运行状况检查，包括TCP，HTTP，Nagios / Sensu兼容脚本或基于的Eureka的TTL。 客户端节点参与基于gossip的健康检查，该检查分发健康检查的工作，而不像集中式心跳，这成为可扩展性挑战。 发现请求被路由到当选的Consul领导者，这使他们默认情况下非常一致。 允许过时读取的客户端允许任何服务器处理其请求，从而允许像Eureka一样的线性可伸缩性。

Consul的强烈一致性意味着它可以用作领导者选举和集群协调的锁定服务。 Eureka不提供类似的保证，并且通常需要为需要执行协调或具有更强一致性需求的服务运行ZooKeeper。

Consul提供了支持面向服务的体系结构所需的功能工具包。 这包括服务发现，还包括丰富的运行状况检查，锁定，键/值，多数据中心联合，事件系统和ACL。 Consul和consul-template和envconsul等工具生态系统都试图最大限度地减少集成所需的应用程序更改，以避免需要通过SDK进行本机集成。 Eureka是更大的Netflix OSS套件的一部分，该套件期望应用程序相对同质且紧密集成。 因此，Eureka只解决了有限的一部分问题，期望其他工具如ZooKeeper可以同时使用。

Eureka Server端采用的是P2P的复制模式，但是它不保证复制操作一定能成功，因此它提供的是一个最终一致性的服务实例视图；Client端在Server端的注册信息有一个带期限的租约，一旦Server端在指定期间没有收到Client端发送的心跳，则Server端会认定为Client端注册的服务是不健康的，定时任务将会将其从注册表中删除。Consul与Eureka不同，Consul采用Raft算法，可以提供强一致性的保证，Consul的agent相当于Netflix Ribbon + Netflix Eureka Client，而且对应用来说相对透明，同时相对于Eureka这种集中式的心跳检测机制，Consul的agent可以参与到基于goosip协议的健康检查，分散了server端的心跳检测压力。除此之外，Consul为多数据中心提供了开箱即用的原生支持等。
Consul下载和安装

Consul采用Go语言编写，支持Linux、Mac、Windows等各大操作系统，本文使用windows操作系统，下载地址：https://www.consul.io/downloads.html，下完成后解压到计算机目录下，解压成功后，只有一个可执行的consul.exe可执行文件。打开cmd终端，切换到目录，执行以下命令：

consul --version

终端显示如下：

Consul v1.4.2
Protocol 2 spoken by default, understands 2 to 3 (agent will automatically use p
rotocol >2 when speaking to compatible agents)

证明consul下载成功了，并可执行。

consul的一些常见的执行命令如下：
命令 	解释 	示例
agent 	运行一个consul agent 	consul agent -dev
join 	将agent加入到consul集群 	consul join IP
members 	列出consul cluster集群中的members 	consul members
leave 	将节点移除所在集群 	consul leave

更多命令请查看官方网站：https://www.consul.io/docs/commands/index.html

开发模式启动：

consul agent -dev 

启动成功，在浏览器上访问：http://localhost:8500，显示的界面。


pring cloud consul

该项目通过自动配置并绑定到Spring环境和其他Spring编程模型成语，为Spring Boot应用程序提供Consul集成。通过几个简单的注释，您可以快速启用和配置应用程序中的常见模式，并使用基于Consul的组件构建大型分布式系统。提供的模式包括服务发现，控制总线和配置。智能路由（Zuul）和客户端负载平衡（Ribbon），断路器（Hystrix）通过与Spring Cloud Netflix的集成提供。
使用spring cloud consul来服务注册与发现

本小节以案例的形式来讲解如何使用Spring Cloud Consul来进行服务注册和发现的，并且使用Feign来消费服务。再讲解之前，已经启动consul的agent，并且在浏览器上http://localhost:8500能够显示正确的页面。本案例一共有2个工程，分别如下：
工程名 	端口 	描述
consul-provider 	8655 	服务提供者
consul-consumer 	8666 	服务消费者

其中，服务提供者和服务消费者分别向consul注册，注册完成后，服务消费者通过FeignClient来消费服务提供者的服务。

