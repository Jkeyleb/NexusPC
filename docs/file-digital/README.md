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

## 6. Autoevaluación SCAMPI

_(pendiente — sección siguiente)_

## 7. Conclusiones

_(pendiente — se completa al cierre del sprint)_