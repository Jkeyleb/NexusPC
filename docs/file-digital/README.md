# File Digital — STLI (Sistema de Trazabilidad y Logística Inversa)
## Curso: Desarrollo de Software I — CMMI Nivel 2 + Scrum

## 1. Resumen del proyecto

Proyecto: Diseño e implementación del Sistema de Trazabilidad y Logística Inversa (STLI)
para Backus, orientado a digitalizar la gestión de envases retornables, el control de
calidad del vidrio y la planificación de rutas de recolección.

El desarrollo sigue un ciclo de vida ágil (Scrum) bajo el marco de procesos exigido
por CMMI Nivel 2, evidenciado en la gestión de requisitos (REQM), el seguimiento del
proyecto (PMC) y el control de configuración (CM) reflejado en el flujo de branches.

## 2. Origen del código base

Este repositorio parte de un proyecto previo (NexusPC), reutilizado como base técnica
para la entrega final, conforme a lo autorizado por el profesor (permitió usar
cualquier proyecto anterior). Las entidades del dominio original se mapean
conceptualmente al dominio de STLI:

| Entidad NexusPC | Equivale a (STLI) |
|---|---|
| Producto | Envase |
| Cliente  | Almacén / Punto de recolección |
| Venta    | Movimiento de envase |

## 3. Flujo de trabajo (CM)

Estructura de branches:
- `main`: código estable + este File Digital
- `developer`: integración de historias de usuario en desarrollo
- `test/qa`: validación antes de pasar a producción

Flujo por historia: `feature/HU-XXX` → PR a `developer` → merge a `test/qa` (con
validación documentada) → merge a `main`.

## 4. Trazabilidad de Historias de Usuario — Sprint 1

| HU | Descripción | Estado | Branch feature | Evidencia (commit) |
|---|---|---|---|---|
| HU-S1-001 a 007 | Seguridad, roles, JWT, middleware, UI login | Completado | `feature/HU-S1-auth-hardening` | `1c95a2d` |
| HU-S1-008 | Esquema de Inventario de Envases | Completado | `feature/HU-S1-008-esquema-inventario` | `0b93fe2` |
| HU-S1-014 | UI base y componentes del Dashboard de Inventario | Completado | `feature/HU-S1-014-dashboard-ui` | `10fabc0` |
| HU-S1-010 | Servicio transaccional para ingreso de lotes | En auditoría PPQA | — | — |
| HU-S1-016 | Formulario de registro e ingreso de lotes | En revisión | — | — |
| HU-S1-009, 011, 012, 015 | Stock por almacén, salidas, alertas, tiempo real | En progreso | — | — |
| HU-S1-013, 017, 018, 022, 024 | Rotación mensual, salidas/despachos, notificaciones, carga CSV, auditoría de accesos | Por hacer | — | — |
| HU-S1-023 | Bloqueo temporal de cuenta (CR-002) | Blocked | — | — |
| HU-S1-019 | Descarga de reportes mensuales | Backlog | — | — |
| HU-S1-020 | Contenedor Docker BD desarrollo | Pausado (sin entorno Docker disponible) | — | — |
| HU-S1-021 | Pipeline CI/CD básico | Pendiente | — | — |

## 5. Evidencia del ciclo completo de branches

Historial verificable con:

```bash
git merge-base --is-ancestor <commit> main
```

Confirmado para los siguientes commits, integrados en `developer`, `test/qa` y `main`:

- `1c95a2d` — HU-S1-001 a 007 (autenticación)
- `0b93fe2` — HU-S1-008 (esquema de inventario)
- `10fabc0` — HU-S1-014 (dashboard)

## 6. Autoevaluación SCAMPI (Nivel 2 — Managed)

Autoevaluación informal del equipo, basada en evidencia recogida durante el
Sprint 1 (commits, PRs, tablero de Asana e incidencias reales del proceso).

| Área de Proceso (CMMI Nivel 2) | Práctica Evaluada / Evidencia | Calificación | Recomendación |
|---|---|---|---|
| **REQM** — Gestión de Requisitos | Cada commit y PR referencia el ID de la historia de usuario (ej. `feat(HU-S1-008): ...`), permitiendo trazabilidad directa entre backlog y código. | **TI** | Mantener la convención de commits; agregar el link directo a la tarjeta de Asana en la descripción de cada PR. |
| **REQM** — Gestión de cambios a requisitos | HU-S1-023 (Blocked) está ligada explícitamente a una solicitud de cambio formal (CR-002). | **PI** | Formalizar una plantilla única de CR para todas las solicitudes de cambio, no solo para las bloqueadas. |
| **PP** — Planificación del Proyecto | Historias organizadas y priorizadas en Asana antes de iniciar el sprint (Backlog → Por Hacer → En progreso). | **TI** | Ninguna; práctica consolidada. |
| **PMC** — Monitoreo y Control | Tablero con estados granulares (En progreso, En revisión, Auditoría PPQA, Blocked), no solo "Hecho/Pendiente". | **TI** | Agregar fecha estimada de cierre por historia para medir desviación de cronograma. |
| **CM** — Gestión de Configuración | Estructura formal de 3 branches (`main`, `developer`, `test/qa`) con flujo de PR por historia, verificado con `git merge-base --is-ancestor`. | **PI** | Durante el sprint se detectaron fallos de ejecución (commit directo sobre `main`, merges sin `push`). Corregidos, pero se recomienda una checklist de PR antes de cerrar cada historia. |
| **PPQA** — Aseguramiento de Calidad de Procesos y Productos | Columna dedicada "Auditoría PPQA" en el backlog, distinta de revisión de código; notas de prueba (`test-log.md`) previas a cada merge a `main`. | **PI** | Las notas de prueba fueron breves; definir criterios mínimos de aceptación por historia antes de marcarla como validada. |
| **MA** — Medición y Análisis | No se definieron métricas cuantitativas del sprint (velocidad, historias por estado a lo largo del tiempo, tiempo promedio de ciclo). | **NI** | Incorporar métricas básicas de Asana (burndown o conteo por estado) en el próximo sprint. |
| **SAM** — Gestión de Acuerdos con Proveedores | No aplica en este sprint (no se contrataron proveedores externos). | **N/A** | Evaluar en sprints donde se integren servicios de terceros (ej. pasarela de notificaciones). |

### Conclusión de la autoevaluación
El equipo alcanza un nivel de madurez consistente con **CMMI Nivel 2 (Gestionado)**
en REQM, PP y PMC. CM y PPQA están en implementación parcial (PI): el proceso
está definido y se sigue, pero su ejecución tuvo errores típicos de un equipo
aplicándolo por primera vez, detectados y corregidos mediante verificación activa
(no asumida). MA es la brecha más clara — el sprint se gestionó de forma
cualitativa, sin métricas cuantitativas de seguimiento.