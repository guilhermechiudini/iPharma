package model;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {
    private String emailRemetente;
    private String senhaRemetente;
    
    public JavaEmail() {
        // Definindo as informações
        this.emailRemetente = "ipharmaApp2023@gmail.com";
        this.senhaRemetente = "tecqkoluixhcercu";
    }
    
    public String enviarEmail(String email) {
        String codigo = gerarCodigo();
        // Realizando a autenticação
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailRemetente, senhaRemetente);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRemetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Pedido de Redefinição de Senha");
            message.setText(codigo + " é seu código de verificação para a redefinição de senha.");
            // Enviando o e-mail
            Transport.send(message);
        } 
        catch (MessagingException me) {
            System.out.println("Erro: " + me.getMessage());
            codigo = null;
        }
        return codigo;
    }
    
    public String gerarCodigo() {
        Random random = new Random();
        // Gera um número inteiro aleatório entre 0 e 9999
        int codigo = random.nextInt(10000);
        // Formata o número com quatro dígitos, preenchendo com zeros à esquerda se necessário
        String codigoFormatado = String.format("%04d", codigo);
        // Retorna o código gerado
        return codigoFormatado;
    }
    
}
