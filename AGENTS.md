# AGENTS.md — Reglas permanentes del proyecto FinanzApp

> Universidad Mariano Gálvez de Guatemala · Proyecto de Tesis
> Válido para **todas las sesiones** y **todos los agentes** de este repositorio.

---

## 1. Stack tecnológico obligatorio

| Elemento | Decisión fija |
|---|---|
| Lenguaje | Kotlin |
| `minSdk` | 26 |
| `compileSdk` / `targetSdk` | 35 |
| UI | 100 % Jetpack Compose + Material3 · **Prohibido XML views** |
| Arquitectura | Clean Architecture (domain / data / presentation) + MVVM |
| Inyección de dependencias | Hilt |
| Persistencia local | Room + SQLCipher (AES-256) |
| Tareas en segundo plano | WorkManager |
| Nube (sólo lectura) | Cloud Firestore — **únicamente** para el diccionario comercio→categoría |

---

## 2. Reglas de privacidad y seguridad (NO negociables)

- Los datos transaccionales del usuario **nunca salen del dispositivo**.
- Cloud Firestore se usa en **modo lectura únicamente** y **sólo** para el diccionario comercio→categoría. Nunca para datos del usuario.
- **Prohibido:**
  - Backend propio o de terceros para datos transaccionales.
  - Enviar datos financieros a cualquier servidor.
  - Trackers, analítica de terceros o publicidad.
  - Retrofit / REST hacia bancos o entidades financieras externas.
- Privacidad por diseño aplicada en todas las capas.

---

## 3. Convención de paquetes

```
gt.edu.umg.finanzapp
├── domain
│   ├── model
│   ├── repository
│   └── usecase
├── data
│   ├── local
│   ├── remote
│   ├── repository
│   ├── mapper
│   └── di
├── presentation
│   ├── navigation
│   ├── screen
│   └── components
└── di
```

---

## 4. Convención de commits

```
<tipo>: parte <NN> - <descripción breve>
```

| Tipo | Uso |
|---|---|
| `feat` | Nueva funcionalidad |
| `fix` | Corrección de error |
| `docs` | Documentación |
| `test` | Pruebas |

**Ejemplo:** `feat: parte 04 - room`

---

## 5. Flujo de ramas

```
feature/* ──► develop ──► main
```

- `feature/*` → rama de trabajo para cada parte/historia.
- `develop` → integración continua del equipo.
- `main` → **sólo se mergea con revisión y aprobación del líder del equipo**.

---

## 6. Definition of Done (DoD)

Una tarea se considera **terminada** cuando cumple **todos** los criterios:

- [ ] Las pruebas unitarias pasan (cobertura mínima **70 %** en la capa de dominio).
- [ ] La funcionalidad es demostrable en un **dispositivo físico**.
- [ ] Revisada por el **Product Owner** contra la historia de usuario correspondiente.
- [ ] Sin regresiones en las pruebas existentes.
- [ ] Documentación técnica actualizada.

---

## 7. Pruebas

- Las pruebas se realizan **únicamente con datos sintéticos**.
- Cobertura mínima obligatoria: **70 %** en la capa `domain`.
- Frameworks permitidos: JUnit 4/5, MockK, Turbine (flows), Robolectric si aplica.

---

## 8. Control de versiones

> **El agente NO ejecuta comandos `git` ni realiza commits.**
> El control de versiones lo gestiona íntegramente el equipo humano.
