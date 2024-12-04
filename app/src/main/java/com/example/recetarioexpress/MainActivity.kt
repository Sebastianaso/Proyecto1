package com.example.recetarioexpress

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recetarioexpress.data.UsuarioRepository
import com.example.recetarioexpress.navigation.NavegacionRecetas
import com.example.recetarioexpress.ui.theme.PantallaLoginRegistro
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : ComponentActivity() {
    private lateinit var usuarioRepository: UsuarioRepository
    private lateinit var googleSignInClient: GoogleSignInClient  // Ensure this is initialized in onCreate
    private val firebaseAuth = FirebaseAuth.getInstance()

    // Google Sign-In result handler
    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleGoogleSignInResult(task)
        }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioRepository = UsuarioRepository(this)

        // Initialize Google Sign-In client
        googleSignInClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )

        setContent {
            val estaLogeado = remember { mutableStateOf(false) }
            val usuarioActual = remember { mutableStateOf("") }

            MaterialTheme {
                Surface {
                    if (estaLogeado.value) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text("RecetarioExpress") },
                                    actions = {
                                        var expanded by remember { mutableStateOf(false) }
                                        IconButton(onClick = { expanded = !expanded }) {
                                            Image(
                                                painter = painterResource(id = R.drawable.usuario),
                                                contentDescription = "Perfil",
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .clip(CircleShape),
                                                contentScale = ContentScale.Crop
                                            )
                                        }

                                        DropdownMenu(
                                            expanded = expanded,
                                            onDismissRequest = { expanded = false }
                                        ) {
                                            Text(
                                                text = "Hola, ${usuarioActual.value}",
                                                modifier = Modifier.padding(8.dp)
                                            )
                                            Divider()
                                            DropdownMenuItem(onClick = {
                                                expanded = false
                                                estaLogeado.value = false
                                                firebaseAuth.signOut()
                                                googleSignInClient.signOut()
                                            }) {
                                                Text("Cerrar sesión")
                                            }
                                        }
                                    }
                                )
                            }
                        ) {
                            NavegacionRecetas()
                        }
                    } else {
                        PantallaLoginRegistro(
                            usuarioRepository = usuarioRepository,
                            onLoginExitoso = { correo, username ->
                                estaLogeado.value = true
                                usuarioActual.value = username
                            },
                            onGoogleSignIn = { onGoogleSignIn() }  // Ensure client is initialized
                        )
                    }
                }
            }
        }
    }

    private fun onGoogleSignIn() {
        if (::googleSignInClient.isInitialized) {  // Check if initialized
            val signInIntent = googleSignInClient.signInIntent
            googleSignInLauncher.launch(signInIntent)
        } else {
            Log.e("GoogleSignIn", "GoogleSignInClient not initialized")
        }
    }

    private fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java)
            val idToken = account?.idToken
            if (idToken != null) {
                firebaseAuthWithGoogle(idToken, account.displayName ?: "")
            }
        } catch (e: ApiException) {
            Log.e("GoogleSignIn", "Error: ${e.message}")
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String, displayName: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Log.d("GoogleSignIn", "Logged in as: ${user?.displayName}")
                } else {
                    Log.e("GoogleSignIn", "Fallo en la autenticación con Firebase")
                }
            }
    }
}