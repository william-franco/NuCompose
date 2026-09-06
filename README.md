# NuCompose

Clone da tela inicial do Nubank construído com Jetpack Compose e Material 3.

Projeto baseado em [TiagoDanin/NuCompose](https://github.com/TiagoDanin/NuCompose), reorganizado com arquitetura MVVM por feature inspirada no [Resonance](../Resonance).

## Stack

| Tecnologia | Versão |
|------------|--------|
| Android Gradle Plugin | 9.4.0 |
| Kotlin | 2.2.10 |
| Compose BOM | 2026.02.01 |
| Koin | 4.2.2 |
| Navigation Compose | 2.9.3 |
| compileSdk / targetSdk | 37 |
| minSdk | 29 |
| JVM | 21 |

## Arquitetura

MVVM por feature com Koin para injeção de dependências:

```
MainActivity → RoutesApp → HomeRoute → HomeViewModel → HomeRepository (mock)
                              ↓
                           HomeView → design/components (stateless)
```

### Estrutura de pacotes

```
src/
├── di/                  # Módulo Koin
├── routes/              # NavHost e rotas
├── design/
│   ├── theme/           # Tema Nubank (Material 3)
│   └── components/      # Widgets reutilizáveis
└── features/home/
    ├── models/          # HomeUiState e data classes
    ├── repositories/    # Dados mock centralizados
    ├── view_models/     # Lógica de apresentação
    ├── views/           # Composables stateless
    └── routes/          # Ponte ViewModel ↔ View
```

## Funcionalidades

- Header com avatar, saudação e ícones de ação
- Saldo da conta e atalhos rápidos (carrossel horizontal)
- Seções de cartão de crédito, empréstimo, seguro e discovery cards
- Dados mock centralizados no `HomeRepository`

## Author

William Franco (Dev mobile).

## License

MIT License

Copyright (c) 2026 William Franco

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
