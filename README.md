# EncryptionDatastoreInAndroidProject

## Description
This project is an Android Jetpack Compose app designed to encrypt DataStore values, ensuring secure storage of sensitive information. It leverages the Android Security Keystore for secure key management and uses advanced encryption techniques.

## Libraries Used
- **Android DataStore**: For data persistence.
- **Kotlinx Serialization (JSON)**: For handling JSON serialization and deserialization.
- **Android Security Keystore APIs**:
  - `android.security.keystore.KeyGenParameterSpec`
  - `android.security.keystore.KeyProperties`
  - `java.security.KeyStore`
  - `javax.crypto.Cipher`
  - `javax.crypto.KeyGenerator`
  - `javax.crypto.SecretKey`
  - `javax.crypto.spec.IvParameterSpec`

## Features
- Encrypts sensitive data before storing in DataStore.
- Uses AES encryption with keys securely stored in Android Keystore.
- Modular and reusable encryption utilities.

## Usage
Clone this repository and run the project on Android Studio. Minimum SDK 26 is required.
