package cn.lgwen.kafka.tool;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

/**
 * 2020/3/5
 * aven.wu
 * danxieai258@163.com
 */
public class WriteToKafka {

    @Test
    public void write() {
        KafkaConnector connector = new KafkaConnector("10.20.128.210:12181");
        KafkaProducer<String, String> producer = connector.kafkaProducer();

        ProducerRecord<String, String> record = new ProducerRecord<>("nova.ana.dandelion.broadcast", "[{\"source\":{\"table\":\"kafka_dws_alarm\"},\"rules\":[{\"ruleId\":\"DAS-MR-1110277\",\"describe\":{\"ruleId\":\"DAS-MR-1110277\",\"type\":\"规则模型\",\"ruleName\":\"EXPLOIT-KIT Possible exploit kit post compromise activity - StrReverse\",\"level\":\"高\",\"stage\":\"扫描探测\",\"description\":\"OS-WINDOWS Microsoft Windows SMB remote code execution attempt\",\"solution\":\"\",\"remarks\":\"\"},\"table\":\"kafka_dws1_alarm,es_dws1_alarm\",\"fields\":\"*\",\"script\":{\"condition\":\"contain(alarmName, 'OS-WINDOWS Microsoft Windows SMB remote code execution attempt')\"}},{\"ruleId\":\"DAS-MR-1130058\",\"describe\":{\"ruleId\":\"DAS-MR-1130058\",\"type\":\"规则模型\",\"ruleName\":\"xmr Coin Miner Login\",\"level\":\"高\",\"stage\":\"漏洞利用\",\"description\":\"尝试致远OA A8无需认证代码执行漏洞利用\",\"solution\":\"\",\"remarks\":\"\"},\"table\":\"kafka_dws1_alarm,es_dws1_alarm\",\"fields\":\"*\",\"script\":{\"condition\":\"regex(alarmName, '.*xmr Coin Miner Login.*')\"}},{\"ruleId\":\"DAS-MTI-2000004\",\"describe\":{\"ruleId\":\"DAS-MTI-2000004\",\"type\":\"情报模型\",\"ruleName\":\"恶意软件下载情报碰撞模型\",\"level\":\"高\",\"stage\":\"安装植入\",\"description\":\"碰撞服务端地址是否为恶意软件分发服务器\",\"solution\":\"对可疑感染主机进行取证，确认恶意文件是否人为下载，及其下载目的、是否运行等。\",\"remarks\":\"\"},\"table\":\"kafka_dws1_alarm,es_dws1_alarm\",\"fields\":\"*\",\"script\":{\"joins\":[\"select a.*, ip.subject from kafka_dws_alarm a join es_monitor_info ip on a.dstIp = ip.subject where confidence >= 0.8 and threatLabelCn = _UTF8'恶意软件'\"]}},{\"ruleId\":\"DAS-MTI-2000008\",\"describe\":{\"ruleId\":\"DAS-MTI-2000008\",\"type\":\"情报模型\",\"ruleName\":\"僵尸网络攻击源情报碰撞模型\",\"level\":\"低\",\"stage\":\"扫描探测\",\"description\":\"碰撞客户端是否为僵尸网络地址\",\"solution\":\"将攻击源列入封堵列表。\",\"remarks\":\"\"},\"table\":\"kafka_dws1_alarm,es_dws1_alarm\",\"fields\":\"*\",\"script\":{\"joins\":[\"select a.*, ip.subject from kafka_dws_alarm a join es_monitor_info ip on a.srcIp = ip.subject where confidence >= 0.8 and threatLabelCn = _UTF8'僵尸网络'\"]}}]},{\"source\":{\"table\":\"kafka_dws_vul\"},\"rules\":[{\"ruleId\":\"DAS-MR-1110410\",\"describe\":{\"ruleId\":\"DAS-MR-1110410\",\"type\":\"规则模型\",\"ruleName\":\"SQL错误信息注入\",\"level\":\"高\",\"stage\":\"漏洞利用\",\"description\":\"弱点描述：SQL注入（SQLInjection）技术在国外最早出现在1999年，我国在2002年后开始大量出现。SQL注入攻击，SQL注入是针对一种数据库而言的，而不是针对网页语言。在任何使用了数据库查询环境下都可能存在，简单来说就是从一个数据库获得未经授权的访问和直接检索。造成SQL注入攻击漏洞的原因，是由于程序在编写Web程序时，没有对浏览器端提交的参数进行严格的过滤和判断。用户可以修改构造参数，提交SQL查询语句，并传递至服务端，从而获取想要的敏感信息，甚至执行危险的代码或系统命令。SQL注入攻击包括通过输入数据从客户端插入或“注入”SQL查询到应用程序。一个成功的SQL注入攻击可以从数据库中获取敏感数据、修改数据库数据（插入/更新/删除）、执行数据库管理操作主要危害：[1]未经授权状况下操作数据库中的数据。[2]恶意篡改网页内容。[3]私自添加系统帐号或者是数据库使用者帐号。[4]网页挂马。[5]与其它漏洞结合，修改系统设置，查看系统文件，执行系统命令等。参考链接：[1]http://baike.baidu.com/view/3896.htm?fr=ala0\",\"solution\":\"一般性的建议：解决SQL注入问题的关键是对所有可能来自用户输入的数据进行严格的检查、对数据库配置使用最小权限原则。[1]所有的查询语句都使用数据库提供的参数化查询接口，参数化的语句使用参数而不是将用户输入变量嵌入到SQL语句中。当前几乎所有的数据库系统都提供了参数化SQL语句执行接口，使用此接口可以非常有效的防止SQL注入攻击。[2]对进入数据库的特殊字符（'尖括号&*;等）进行转义处理，或编码转换。[3]严格限制变量类型，比如整型变量就采用intval()函数过滤，数据库中的存储字段必须对应为int型。[4]数据长度应该严格规定，能在一定程度上防止比较长的SQL注入语句无法正确执行。[5]网站每个数据层的编码统一，建议全部使用UTF-8编码，上下层编码不一致有可能导致一些过滤模型被绕过。[6]严格限制网站用户的数据库的操作权限，给此用户提供仅仅能够满足其工作的权限，从而最大限度的减少注入攻击对数据库的危害。[7]避免网站显示SQL错误信息，比如类型错误、字段不匹配等，防止攻击者利用这些错误信息进行一些判断。[8]确认PHP配置文件中的magicquotesgpc选项保持开启。[9]在部署你的应用前，始终要做安全审评(securityreview)。建立一个正式的安全过程(formalsecurityprocess)，在每次你做更新时，对所有的编码做审评。后面一点特别重要。不论是发布部署应用还是更新应用，请始终坚持做安全审评。[10]千万别把敏感性数据在数据库里以明文存放。[11]使用第三方Web防火墙来加固整个网站系统。应用程序级别的漏洞，仅仅依靠对服务器的基本设置做一些改动是不能够解决的，必须从提高应用程序的开发人员的安全意识入手，加强对代码安全性的控制，在服务端正式处理之前对每个被提交的参数进行合法性检查，以从根本上解决注入问题。\",\"remarks\":\"\"},\"table\":\"kafka_dws1_vul,es_dws1_vul\",\"fields\":\"*\",\"script\":{\"condition\":\"contain(vulName, 'SQL错误信息注入')\"}},{\"ruleId\":\"DAS-MR-1110439\",\"describe\":{\"ruleId\":\"DAS-MR-1110439\",\"type\":\"规则模型\",\"ruleName\":\"phpMyAdmin未授权访问\",\"level\":\"高\",\"stage\":\"安装植入\",\"description\":\"弱点描述：用PHP语言所写的phpMyAdmin，提供了一个基于Web界面的MySQL数据库管理应用程序。最初MySQL的root帐户密码是空的，所以任何人都可以连接到MySQL服务器的根目录，不用密码，并授予所有权限。\",\"solution\":\"一般性的建议：如果你没有设置过MySQL的root密码，服务器root连接不需要任何密码。首次要设置root密码，使用mysqladmin工具。\",\"remarks\":\"\"},\"table\":\"kafka_dws1_vul,es_dws1_vul\",\"fields\":\"*\",\"script\":{\"condition\":\"regex(vulName, '.*(phpMyAdmin).*(未授权访问).*')\"}},{\"ruleId\":\"DAS-MR-1110988\",\"describe\":{\"ruleId\":\"DAS-MR-1110988\",\"type\":\"规则模型\",\"ruleName\":\"敏感文件\",\"level\":\"低\",\"stage\":\"漏洞利用\",\"description\":\"MicrosoftFrontPageServerExtensions任务列表可能包含敏感信息。攻击者读取上述文件的内容，以便进一步攻击目标站点。\",\"solution\":\"[1]删除或者限制访问任务列表。\",\"remarks\":\"\"},\"table\":\"kafka_dws1_vul,es_dws1_vul\",\"fields\":\"*\",\"script\":{\"condition\":\"regex(vulName, '.*(敏感文件).*')\"}}]}]");
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
