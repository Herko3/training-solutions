package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path folder) {
        Path file = folder.resolve(account.getAccount() + ".dat");

        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {

            os.writeUTF(account.getAccount());
            os.writeUTF(account.getOwner());
            os.writeDouble(account.getBalance());

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file");
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream))) {
            String account = dataInputStream.readUTF();
            String owner = dataInputStream.readUTF();
            double balance = dataInputStream.readDouble();
            return new BankAccount(account,owner,balance);
        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

}
