package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	// 我们使用沙箱环境提供的AppId
	public static String app_id = "2016102200735088";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCij8b1EDwEkaO/MiBThVnX0Gl+xuVWM0qdJttJ11MZD3rbR1IrfOwo/L3YHJzHIUw1Y0ry9SpfpN3D65KBo53hRs/yjhq9LzH2HwJK5TbAGP3rOiIugN17Oh8ifFSbVCGZw222AU6dEAgFGrurY2BVJa9oPQPZQiFS4zDJgvDsdOnEKzPuj3PB9nqS2B1sZyLxeSiKK96SRcuyP6s0205zE7dvOP9Swin6S+OlbytcHcfL9djR2x9/PdAdpihI9o7jjWnvyOE75YoBsegWzGNiLeh72o16SNodEBGMFds2K9HqaLf/B7T0aYGZqcmtkN5YV20qYZPcPFKppS/iMLXBAgMBAAECggEAZxZ2PQJGjT8ucBkBlvWBu/JWdCb9WGS+dFonxfPepo3Cgzv/R8S4nmVonpvGcCEViuWkqd3/ORf76jqBdeSkQi/9vvuOyVocfM+9THF+/uLaY0lCU+s0iOiaxevCW55GkJP2Bu1dRQzdiR8i09T5SgXT7m6C+kuNhlq8nY2D6u5TA3T3jlQK5EoluUcmhR++b/zKAtoeVoobuagDPNDKotGiYBRLqcAeMH5uVVAdM5dWu/AJ99AXcfZ+m/Ms+xPKrQGRxWBMxCCno4E/ppRPLAkkxx+iSs9qxBoUS/Nf7Q9zurS1KHucqnh1pwYEO9Li+m/uNsz7H9bGb8koiH2MgQKBgQDwFnj8ZxDTlthQ4GEIoaMGJEcRuZuxx9dp/+aeohsC9SrsT3nvbO1m2CpiMessPBHPeqjaw+9L6U5o+48fDB1Qv3LFH4nU3U6Tbqahs0KVm5ja6yUCl+hp0UbNIX3aqrepKGQ4KdBc01cLDM2mIY+jIg7jRmE2BdVmv0Run5QHHQKBgQCtVe6QaCGt9toY6+S58jMEBCuSdK7qzaGqjk1wSFD6mqlXKXZakPNp4wbBPk4Fgi5NczYwhCB1y/TrIl/pqUF62MfpzzLdCQJqZtYI/UMBRO3yHZ4T0C67X9AEEj10S+OF4VsU90M84+Lorn6KIfaxcmKBE+FPOLNDlxmxoP3T9QKBgHKs2Tb955yY9VOUCOT9h4ecdlGyDPrakDqyHy5wEWTVQ55By+UfazlvULc8Tq7/Niaa2OI9KiRhGLGuTksvFyWFfEVJbiU9W5WyCWc83zXkbxtJq5DUjA9XBXFfaOS0HCtw/oWQ+1QLIg1GHUgXyarKzr+h0zbhjG+aNg58rFDFAoGAKj2txI1L39wvbDFYbSQj4I+vmqJK2jfAdRL2ti05Zsj4CaC2Ef4PA7fqtn8bfmYqKH+yLgKU8oAAsKiQ3R19MpXPqh/vUkRWzV1APbKSeKW2ovEqy8NJECqaQ9O6HDQ+PysbCjHztcwHSRL1DW6XcsjgTnpsxuSXcxpIjawhD10CgYANMY7ds4qhMxjR3lMVtBqArDfIK+d92eGQk8emFFzmuPaaeJ3AaQe1JjwfIMQ/yFCbEHzggQrSxh60g2dvNfZyLSpNuUtw+K/9RHz6Xx8brHbbVLd2/iD3bMg6/sB9+ymuse3/5ERT8ifPwdhzscKJzdcgNnfUTR2Ce9BSQvCFtA==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlcsx43GMVob5UT7wkFgPvDekhD999jEqdj167EtISAUJlM/kzWG5QQSx0TCfBgleyTY2opcjs9/h4BCYUoKVZaojp4t1lyKVh7h4I259+w2kNF7JZyXjqr0xBMCk1+N3O6KSsvcqM2mfzr9uzByLdNYeQ5N9Fj+nDueQk1/cuExEVOhH6hEb5ie3jl+hHJ22Pvrw4ApqIQCmDp4fd0xH9rUk26vNtFYr9gTLcuMkEcTM1q7WXMWODfxNJTH/8x4Usy2WeIdBXTM3jKUmSvXiPlLaLI6CXS97QITFy52dAwJq6DPCi+C5ayU3rYjDrqMrkQVYgdhncYxTe08IELv9/QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 这里我们使用NATAPP提供的隧道地址
	public static String notify_url = "http://thc4a7.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 这里我们使用NATAPP提供的隧道地址
	public static String return_url = "http://thc4a7.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	// public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 我们使用沙箱环境的支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 保存日志文件的路径
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

